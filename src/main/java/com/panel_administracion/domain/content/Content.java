package com.panel_administracion.domain.content;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Content")
@Table(name = "contents")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean flag;

    public Content(DataContentInsert dataRecordContent){
        this.flag = true;
        this.name = dataRecordContent.name();
        this.description = dataRecordContent.description();
    }

    public void deactivateContent(){
        this.flag = false;
    }

    public void updateDataContent(DataContentUpdate dataUpdateContent){
        if (dataUpdateContent.name() != null){
            this.name = dataUpdateContent.name();
        }

        if (dataUpdateContent.description() != null){
            this.description = dataUpdateContent.description();
        }
    }
}
