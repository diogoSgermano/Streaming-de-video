package com.univille.Video.Entidade;

import jakarta.persistence.*;

@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacao;

    @ManyToOne
    @JoinColumn(name="perfil_id", nullable = false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name="idVideo", nullable = false)
    private Video video;

    @Column(nullable = false)
    private int nota;

    private String comentario;

    public Avaliacao() {
    }

    public Avaliacao(Long idAvaliacao, Perfil perfil, Video video, int nota, String comentario) {
        this.idAvaliacao = idAvaliacao;
        this.perfil = perfil;
        this.video = video;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "idAvaliacao=" + idAvaliacao +
                ", perfil=" + perfil +
                ", video=" + video +
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
