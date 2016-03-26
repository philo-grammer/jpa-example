package jpabook.jpashop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by sykim on 2016. 3. 23..
 */
@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    private String artist;
    private String etc;


}
