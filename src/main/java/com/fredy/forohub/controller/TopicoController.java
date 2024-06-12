package com.fredy.forohub.controller;

import com.fredy.forohub.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping
    public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size = 5) Pageable paginacion){
        return topicoRepository.findByStatusTrue(paginacion).map(DatosListadoTopico::new);
    }

    @GetMapping("/{id}")
    public DatosRespuestaTopico retornarDatos(@PathVariable Long id){
        //Topico topico = topicoRepository.getReferenceById(id);
        //var datosTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha_creacion(),topico.getUsuario_id(),topico.getCurso_id(),topico.getStatus());
        //return datosTopico;

        //var datos = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topicoRepository.getReferenceById(id));
        return datosTopico;
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarTopico(datosActualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }
}
