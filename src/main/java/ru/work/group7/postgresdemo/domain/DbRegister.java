package ru.work.group7.postgresdemo.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * @author rnikonov
 */
@Entity
@Getter
@Setter
@Builder(builderClassName = "Builder")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "db_register", schema = "public", catalog = "7unit_big_base")
public class DbRegister {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;

    @Basic
    @Column(name = "count_of_records", nullable = true)
    private Integer countOfRecords;

    @Basic
    @Column(name = "date_added", nullable = true)
    private Date dateAdded;

    @Basic
    @Column(name = "access_level", nullable = true)
    private Integer accessLevel;

}
