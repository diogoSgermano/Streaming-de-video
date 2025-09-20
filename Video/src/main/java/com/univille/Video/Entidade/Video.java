package com.univille.Video.Entidade;

import jakarta.persistence.*;
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVideo;
    //nullable = falase é notnull
    @Column(nullable = false, unique = true, length = 255)
    private String titulo;

    @Column(length = 1000)
    private String descricao;

    @Column(nullable = false)
    private int duracao;


    @ManyToOne
    @JoinColumn(name="categoria_id",nullable = false)
    private Categoria categoria;

    public Video() {
    }

    public Video(Long idVideo, String titulo, String descricao, int duracao, Categoria categoria) {
        this.idVideo = idVideo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.categoria = categoria;
    }

    public Long getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Long idVideo) {
        this.idVideo = idVideo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }




    @Override
    public String toString() {
        return "Video{" +
                "idVideo=" + idVideo +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", duracao=" + duracao +
                ", categoria=" + categoria +
                '}';
    }
}
