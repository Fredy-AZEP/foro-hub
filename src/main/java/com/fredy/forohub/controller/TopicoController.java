package com.fredy.forohub.controller;

import com.fredy.forohub.topico.DatosListadoTopico;
import com.fredy.forohub.topico.DatosRegistroTopico;
import com.fredy.forohub.topico.Topico;
import com.fredy.forohub.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //@GetMapping
    //public List<Topico> listadoTopicos(){
    //    return topicoRepository.findAll();
    //}

    @GetMapping
    public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size = 5) Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }
}
