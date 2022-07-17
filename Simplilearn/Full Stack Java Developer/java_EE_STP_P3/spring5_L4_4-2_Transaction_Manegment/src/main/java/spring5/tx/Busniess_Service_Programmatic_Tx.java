package spring5.tx;



import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;


@Service("busniess_Service_Programmatic_Tx")
public class Busniess_Service_Programmatic_Tx implements Busniess_Service{

	/*
	private final TransactionTemplate transactionTemplate;
	
	 public Busniess_Service_Programmatic_Tx(PlatformTransactionManager platformTransactionManager) {
		this.transactionTemplate = new TransactionTemplate(platformTransactionManager);
		this.transactionTemplate.setTimeout(30);
		this.transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		
		
	} */
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void doBusiness() {
		System.out.println("Hello from transaction");
	}
	
}
