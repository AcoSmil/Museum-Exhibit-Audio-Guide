package org.aco.museumapi.repository;

import org.aco.museumapi.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, String> {
}
