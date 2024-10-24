package com.example.api2024.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.api2024.entity.Adm;
import com.example.api2024.repository.AdmRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    private AdmRepository admRepository;

    // Listar todos os administradores
    @GetMapping("/listar")
    public List<Adm> listarAdm() {
        return admRepository.findAll();
    }

    // Obter o tipo do administrador pelo email
    @GetMapping("/{email}/tipo")
    public String getTipo(@PathVariable String email) throws Exception {
        return admRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Adm não encontrado"))
                .getTipo();
    }

    // Obter informações do administrador pelo email
    @GetMapping("/{email}/infoAdm")
    public Adm getInfoAdm(@PathVariable String email) throws Exception {
        return admRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Adm não encontrado"));
    }

    // Criar um novo administrador (somente super administrador)
    @PostMapping("/criar")
    public ResponseEntity<String> criarAdm(
            @RequestBody Adm novoAdm,
            @RequestParam Long idSuperAdm) {

        Optional<Adm> superAdm = admRepository.findById(idSuperAdm);

        // Verifica se o criador é um super administrador (tipo == '1')
        if (superAdm.isEmpty() || !"1".equals(superAdm.get().getTipo())) {
            return ResponseEntity.status(403)
                    .body("Acesso negado: Apenas super administradores podem criar novos administradores.");
        }

        admRepository.save(novoAdm);
        return ResponseEntity.ok("Administrador criado com sucesso!");
    }

    // Excluir administrador por ID (somente super administrador)
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirAdm(
            @PathVariable Long id,
            @RequestParam Long idSuperAdm) {

        Optional<Adm> superAdm = admRepository.findById(idSuperAdm);

        // Verifica se o usuário solicitante é um super administrador (tipo == '1')
        if (superAdm.isEmpty() || !"1".equals(superAdm.get().getTipo())) {
            return ResponseEntity.status(403)
                    .body("Acesso negado: Apenas super administradores podem excluir administradores.");
        }

        admRepository.deleteById(id);
        return ResponseEntity.ok("Administrador excluído com sucesso.");
    }
}
