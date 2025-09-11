package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosAtualizarMedico;
import med.voll.api.medico.Medico;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteDadosDTO;
import med.voll.api.paciente.PacienteListagemDTO;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteContoller {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid PacienteDadosDTO paciente){
        repository.save(new Paciente(paciente));
    }

    @GetMapping
    public Page<PacienteListagemDTO> listar(@PageableDefault(sort = {"nome"}, size = 10) Pageable pageable){
        return repository.findAll(pageable).map(PacienteListagemDTO::new);
    }


}
