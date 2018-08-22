package com.pluralsight.util;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class LifecyleListener {
	  @PrePersist
	  void prePersist(Object object) {
	    System.out.println(".LifecyleListener       prePersist()");
	  }

	  @PostPersist
	  void postPersist(Object object) {
	    System.out.println(".LifecyleListener       postPersist()");
	  }

	  @PreUpdate
	  void preUpdate(Object object) {
	    System.out.println(".LifecyleListener       preUpdate()");
	  }

	  @PostUpdate
	  void postUpdate(Object object) {
	    System.out.println(".LifecyleListener       postUpdate()");
	  }

	  @PreRemove
	  void preRemove(Object object) {
	    System.out.println(".LifecyleListener       preRemove()");
	  }

	  @PostRemove
	  void postRemove(Object object) {
	    System.out.println(".LifecyleListener       postRemove()");
	  }

	  @PostLoad
	  void postLoad(Object object) {
	    System.out.println(".LifecyleListener       postLoad()");
	  }
}
