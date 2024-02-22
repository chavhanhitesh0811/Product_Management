//package com.Java_Training.Product_Management.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.Java_Training.Product_Management.entities.VisitedRecord;
//
//@Repository
//public interface VisitedRecordRepo extends JpaRepository<VisitedRecord, Integer> {
//
//	public VisitedRecord findByUserIdAndProductId(int userId , int productId);
//	
//	@Query("select v FROM VisitedRecord v WHERE userId =:u ORDER BY date DESC")
//	public List<VisitedRecord> findByUserId(@Param("u") int userId);
//	
//	@Query("delete FROM VisitedRecord v WHERE userId =:u AND productId =:p")
//	public void deleteRecord(@Param("u") int userId ,@Param("p") int productId);
//	
////	public VisitedRecord findByUserIdAndProductId(int userId , int productId);
//}
