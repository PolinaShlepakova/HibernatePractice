package com.polinashlepakova.practice6.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(query = "SELECT u FROM UserEntity u", name =
                UserEntity.FIND_ALL),
        @NamedQuery(query = "SELECT u FROM UserEntity u " +
                "WHERE u.lastName = :lastName",
                name = UserEntity.FIND_BY_LAST_NAME),
        @NamedQuery(query = "SELECT u FROM UserEntity u WHERE " +
                "u.lastName LIKE CONCAT('%', :word, '%') OR " +
                "u.firstName LIKE CONCAT('%', :word, '%')",
                name = UserEntity.FIND_BY_CONTAINIG_IN_LAST_OR_FIRST_NAME)
})
public class UserEntity {

    public static final String FIND_ALL = "UserEntity.FIND_ALL";
    public static final String FIND_BY_LAST_NAME = "UserEntity" +
            ".FIND_BY_LAST_NAME";
    public static final String FIND_BY_CONTAINIG_IN_LAST_OR_FIRST_NAME =
            "UserEntity.FIND_BY_CONTAINIG_IN_LAST_OR_FIRST_NAME";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

}
