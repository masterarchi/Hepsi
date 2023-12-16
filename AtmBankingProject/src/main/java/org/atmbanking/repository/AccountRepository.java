package org.atmbanking.repository;

import org.atmbanking.entity.Account;
import org.atmbanking.entity.User;
import org.atmbanking.util.DbConnection;
import org.atmbanking.util.RandomGenerateAccountNo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRepository {

    public void createAccount(User user){
        String query = "insert into accounts(user_id, account_no) values(?,?)";
        PreparedStatement preparedStatement = null;

        Account account = Account.builder()
                .userId(user.getId())
                .accountNo(RandomGenerateAccountNo.generateAccountNo())
                .build();


        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2, account.getAccountNo());
            if (preparedStatement.executeUpdate()>0){
                System.out.println("hesabınız oluşturuldu"+account.getAccountNo());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    //list<Account> getAccountByEmail(String email)
    //transferMoney(int amount,String accountNo)

    public List<Account> getAccountsByEmail(String email) {
        String query = "SELECT * FROM accounts WHERE user_id IN (SELECT id FROM users WHERE email = ?)";
        List<Account> accounts = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String accountNo = resultSet.getString("account_no");
                // You should have a constructor or builder method for Account class
                Account account = Account.builder()
                        .userId(userId)
                        .accountNo(accountNo)
                        .build();
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close resources in a finally block
            DbConnection.closeResources(connection, preparedStatement, resultSet);
        }

        return accounts;
    }
    public void transferMoney(int amount, String sourceAccountNo, String targetAccountNo) {
        String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE account_no = ?";
        String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE account_no = ?";
        Connection connection = null;
        PreparedStatement debitStatement = null;
        PreparedStatement creditStatement = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            // Debit the source account
            debitStatement = connection.prepareStatement(debitQuery);
            debitStatement.setInt(1, amount);
            debitStatement.setString(2, sourceAccountNo);
            int debitResult = debitStatement.executeUpdate();

            // Credit the target account
            creditStatement = connection.prepareStatement(creditQuery);
            creditStatement.setInt(1, amount);
            creditStatement.setString(2, targetAccountNo);
            int creditResult = creditStatement.executeUpdate();

            if (debitResult > 0 && creditResult > 0) {
                connection.commit();
                System.out.println("Money transfer successful");
            } else {
                connection.rollback();
                System.out.println("Money transfer failed");
            }
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackException) {
                throw new RuntimeException(rollbackException);
            }
            throw new RuntimeException(e);
        } finally {
            // Close resources in a finally block
            DbConnection.closeResources(connection, debitStatement, null);
            DbConnection.closeResources(null, creditStatement, null);
        }
    }








}
