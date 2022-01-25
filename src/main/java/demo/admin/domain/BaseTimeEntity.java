package demo.admin.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
/* BaseTimeEntity 클래스는 모든 Entity의 상위 클래스가 되어
    "Entity의 createdDate, modifiedDate을 자동으로 관리"하는 역할.
 */

/* @MappedSuperclass
    - JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도
        칼럼으로 인식하도록 함.

   @EntityListeners(AuditingEntityListener.class)
   - BaseTimeEntit 클래스에 Auditing 기능을 포함시킴

   @CreatedDate
   - Entity가 생성되어 저장될 때 시간이 자동 저장됨.

   @LastModifiedDate
   - 조회한 Entity의 값을 변경할 때 시간이 자동 저장됨.
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
