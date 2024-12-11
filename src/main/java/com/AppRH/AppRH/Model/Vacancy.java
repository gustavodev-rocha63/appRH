    package com.AppRH.AppRH.Model;
    import java.io.Serializable;
    import java.math.BigDecimal;
    import java.util.List;

    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotEmpty;

    @Entity

    public class Vacancy implements Serializable{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String date;

        @Column(nullable = false)
        private String description;

        @Column(nullable = false)
        private BigDecimal wage;

        @OneToMany(mappedBy = "vacancy")
        private List<Candidates> candidates;

        public long getId(){
            return id;
        }

        public void setId(long id){
            this.id = id;
        }
        public @NotEmpty String getName() {
            return name;
        }

        public void setName(@NotEmpty String name) {
            this.name = name;
        }

        public @NotEmpty String getDate() {
            return date;
        }

        public void setDate(@NotEmpty String date) {
            this.date = date;
        }

        public BigDecimal getWage() {
            return wage;
        }

        public void setWage(BigDecimal wage) {
            this.wage = wage;
        }

        public @NotEmpty String getDescription() {
            return description;
        }

        public void setDescription(@NotEmpty String description) {
            this.description = description;
        }

        public List<Candidates> getCandidates() {
            return candidates;
        }

        public void setCandidates(List<Candidates> candidates) {
            this.candidates = candidates;
        }
    }
