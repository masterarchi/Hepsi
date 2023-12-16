package example.repository;

import example.entity.Arac;
import example.util.MyRepositoryFactory;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AracRep extends MyRepositoryFactory<Arac, Long> {
    public AracRep() {
        super(Arac.class);
    }


    public List<Arac> findByMarkaAndModel(String marka, String model) {
        openSession();
        CriteriaQuery<Arac> criteriaQuery = getCriteriaBuilder().createQuery(Arac.class);
        Root<Arac> root = criteriaQuery.from(Arac.class);
        criteriaQuery.select(root);
        criteriaQuery.where(getCriteriaBuilder().equal(root.get("marka"),
                marka), getCriteriaBuilder().equal(root.get("model"),model));
        List<Arac> result = getSession().createQuery(criteriaQuery).getResultList();
        return result;
    }

    public List<Arac> findAllByDurum (boolean durum) {
        openSession();
        CriteriaQuery<Arac> criteriaQuery = getCriteriaBuilder().createQuery(Arac.class);
        Root<Arac> root = criteriaQuery.from(Arac.class);
        criteriaQuery.select(root);
        criteriaQuery.where(getCriteriaBuilder().equal(root.get("isActive"),durum));
        List<Arac> result = getSession().createQuery(criteriaQuery).getResultList();
        return result;
    }

    public List<Arac> findAllByDurumNative (boolean durum) {
        openSession();
        String query = "Select * from Arac where isActive=durum";
        return getSession().createNativeQuery(query,Arac.class).setParameter("durum",durum).getResultList();

    }

}
