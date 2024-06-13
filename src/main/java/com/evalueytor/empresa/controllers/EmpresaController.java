package com.evalueytor.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.evalueytor.empresa.repositories.EmpresaRepository;
import com.evalueytor.empresa.models.Empresa;
import com.evalueytor.empresa.repositories.ProveedorRepository;
import com.evalueytor.empresa.models.Proveedor;

@RestController
@RequestMapping("/api")
public class EmpresaController {
    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    ProveedorRepository proveedorRepository;

    // Listar todas las empresas
    @GetMapping("/empresa/findallempresa")
    public List<Empresa> listarEmpresa() {
        return empresaRepository.findAll();
    }

    // Listar empresa por Id
    @GetMapping("/empresa/findbyid/{id}")
    public ResponseEntity<Empresa> obtenerEmpresaPorId(@PathVariable Long id) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        return empresaOptional.map(empresa -> new ResponseEntity<>(empresa, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear una nueva empresa
    @PostMapping("/empresa/save")
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa nuevaEmpresa) {
        Empresa empresaGuardada = empresaRepository.save(nuevaEmpresa);
        return new ResponseEntity<>(empresaGuardada, HttpStatus.CREATED);
    }

    // Actualizar empresa
    @PutMapping("/empresa/updatebyid/{id}")
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresaActual) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        return empresaOptional.map(empresa -> {
            empresa.setId(id);
            empresa.setNombre(empresaActual.getNombre());
            empresa.setDireccion(empresaActual.getDireccion());
            Empresa empresaActualGuardado = empresaRepository.save(empresa);
            return new ResponseEntity<>(empresaActualGuardado, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar una empresa por ID
    @DeleteMapping("/empresa/deletebyid/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable Long id) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isPresent()) {
            empresaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Listar todos los proveedores
    @GetMapping("/proveedor/findallproveedor")
    public List<Proveedor> listarProveedor() {
        return proveedorRepository.findAll();
    }

    // Listar proveedor por Id
    @GetMapping("/proveedor/findbyid/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable Long id) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        return proveedorOptional.map(proveedor -> new ResponseEntity<>(proveedor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

   // Crear un nuevo proveedor
    @PostMapping("/proveedor/save")
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor nuevoProveedor) {
    Proveedor proveedorGuardado = proveedorRepository.save(nuevoProveedor);
    return new ResponseEntity<>(proveedorGuardado, HttpStatus.CREATED);
}


    // Actualizar proveedor
    @PutMapping("/proveedor/updatebyid/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedorActual) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        return proveedorOptional.map(proveedor -> {
            proveedor.setId(id);
            proveedor.setNombre(proveedorActual.getNombre());
            proveedor.setDireccion(proveedorActual.getDireccion());
            Proveedor proveedorActualGuardado = proveedorRepository.save(proveedor);
            return new ResponseEntity<>(proveedorActualGuardado, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar un proveedor por ID
    @DeleteMapping("/proveedor/deletebyid/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        if (proveedorOptional.isPresent()) {
            proveedorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
