package me.leesh.board.post.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import me.leesh.board.common.domain.model.BaseEntity

@Entity
class Post(
    createdBy: String,
) : BaseEntity(createdBy) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
    var title: String = ""
        protected set
    var content: String = ""
        protected set
}
