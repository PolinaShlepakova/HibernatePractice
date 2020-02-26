package com.polinashlepakova.practice6.service;

import com.polinashlepakova.practice6.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EntityManager entityManager;

    // - Додати вичитування всі користувачів з бази даних
    // - Додати вичитування всіх користувачів з конкретним прізвищем(всі
    // користувачі, в яких прізвище Smith)
    // - Додати вичитку всіх користувачів, в яких ім’я або прізвище містить
    // слово
    //   (всі користувачів, в яких ім’я бо прізвище містить літеру «а»)

    @Transactional
    public UserEntity createUser(String firstName, String lastName,
                                 String email) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        return entityManager.merge(user);
    }

    @Transactional
    public List<UserEntity> findAll() {
        return entityManager.createNamedQuery(UserEntity.FIND_ALL,
                UserEntity.class).getResultList();
    }

    @Transactional
    public List<UserEntity> findByLastName(final String lastName) {
        return entityManager.createNamedQuery(UserEntity.FIND_BY_LAST_NAME,
                UserEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Transactional
    public List<UserEntity> findByContainingInLastOrFirstName(final String word) {
        return entityManager.createNamedQuery(
                UserEntity.FIND_BY_CONTAINIG_IN_LAST_OR_FIRST_NAME,
                UserEntity.class)
                .setParameter("word", word)
                .getResultList();
    }

}

