package ru.work.group7.postgresdemo.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
@Table(name = "db_data", schema = "public", catalog = "7unit_big_base")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class DbData {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Type(type = "jsonb")
    @Column(name = "data", columnDefinition = "jsonb")
    private Map<String,Object> data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "register_id")
    private DbRegister registerId;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class DataRow implements Serializable {
        private String text;
    }
}
