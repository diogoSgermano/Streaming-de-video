package com.univille.Video.Entidade;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Visualizacao {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idVisualizacao;

    @ManyToOne
    @JoinColumn(name="idPerfil",nullable = false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name="idVideo", nullable = false)
    private Video video;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private int progresso;

    public Visualizacao() {
    }

    public Visualizacao(Long idVisualizacao, Perfil perfil, Video video, LocalDateTime dataHora, int progresso) {
        this.idVisualizacao = idVisualizacao;
        this.perfil = perfil;
        this.video = video;
        this.dataHora = dataHora;
        this.progresso = progresso;
    }

    public Long getIdVisualizacao() {
        return idVisualizacao;
    }

    public void setIdVisualizacao(Long idVisualizacao) {
        this.idVisualizacao = idVisualizacao;
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }

    @Override
    public String toString() {
        return "Visualizacao{" +
                "idVisualizacao=" + idVisualizacao +
                ", perfl=" + perfil +
                ", video=" + video +
                ", dataHora=" + dataHora +
                ", progresso=" + progresso +
                '}';
    }
}
