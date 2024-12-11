            package com.AppRH.AppRH.Model;

            import jakarta.persistence.*;
            import jakarta.validation.constraints.NotEmpty;

            @Entity
            @Table(name = "candidates")
            public class Candidates {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private long id;

                @Column(unique = true)
                private String rg;

                @NotEmpty
                private String nameCandidate;

                @NotEmpty
                private String email;

                @ManyToOne
                @JoinColumn(name = "vacancy_id")
                private Vacancy vacancy;

                public void setId(Long id){
                    this.id = id;
                }

                public String getRg() {
                    return rg;
                }

                public void setRg(String rg) {
                    this.rg = rg;
                }

                public  String getNameCandidate() {
                    return nameCandidate;
                }

                public void setNameCandidate(String nameCandidate) {
                    this.nameCandidate = nameCandidate;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail( String email) {
                    this.email = email;
                }
            }
