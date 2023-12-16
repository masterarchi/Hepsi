package org.atmbanking.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.atmbanking.entity.User;
import org.atmbanking.util.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRepository {

    public User login(String email, String password){
        String query = "select * from users where email=? and password=?";
        PreparedStatement preparedStatement=null;


        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int existedId = resultSet.getInt("id");
                String existedName = resultSet.getString("name");
                String existedEmail = resultSet.getString("email");
                String existedPassword = resultSet.getString("password");
                User user = User.builder()
                        .id(existedId)
                        .name(existedName)
                        .email(existedEmail)
                        .build();
                return user;

            }else {
                throw new RuntimeException("kullanıcı bulunamadı");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                preparedStatement.close();
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }









}
