package com.fredy.forohub.controller;

import com.fredy.forohub.topico.DatosRegistroTopico;
import com.fredy.forohub.topico.Topico;
import com.fredy.forohub.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico){
        System.out.println("El reques llego correctamente");
        System.out.println(datosRegistroTopico);

        topicoRepository.save(new Topico(datosRegistroTopico));

    }
}
