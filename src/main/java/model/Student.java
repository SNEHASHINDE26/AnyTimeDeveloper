package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "student_program")
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @Column(name="s_id")
        private  int Id;

        @Column(name="s_name")
        private String Name;

        @Column(name="s_branch")
        private String Branch;


}


