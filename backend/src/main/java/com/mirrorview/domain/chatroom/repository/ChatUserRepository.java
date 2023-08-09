package com.mirrorview.domain.chatroom.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mirrorview.domain.chatroom.domain.ChatUser;

@Repository
public interface ChatUserRepository extends CrudRepository<ChatUser, String> {
	Optional<ChatUser> findById(String userId);
}
