package product.repository;

import product.entity.Category;
import product.entity.Customer;
import product.util.MyRepositoryFactory;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class CustomerRepository extends MyRepositoryFactory<Customer,Long> {
    public CustomerRepository() {
        super(Customer.class);
    }

    public Optional<Customer> findCustomerByIdentity(String identity){
        openSession();
        CriteriaQuery<Customer> criteriaQuery = getCriteriaBuilder().createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root).where(getCriteriaBuilder().equal(root.get("identity"),identity));

        List<Customer> singleResult = getSession().createQuery(criteriaQuery).getResultList();
        closeSession();
        //return Optional.ofNullable(singleResult.get(0));
        return singleResult.isEmpty()?Optional.empty():Optional.ofNullable(singleResult.get(0));

        /*
        Customer singleResult = null;


        try {
            singleResult = getSession().createQuery(criteriaQuery).getSingleResult();
            closeSession();
        } catch (NoResultException e) {
            System.out.println("Not found");
        }

        */
        //        if (singleResult==null){
//            return Optional.empty();
//        }
//        return Optional.of(singleResult);
    }
















}


