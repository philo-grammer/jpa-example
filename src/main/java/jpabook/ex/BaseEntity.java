package jpabook.ex;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by sykim on 2016. 3. 23..
 */
@MappedSuperclass
public class BaseEntity {

    private Date createDate;        //등록일
    private Date lastModifiedDate;  //수정일

    //Getter, Setter

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
