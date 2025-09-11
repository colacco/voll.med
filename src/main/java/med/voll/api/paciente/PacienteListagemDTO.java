package med.voll.api.paciente;

public record PacienteListagemDTO(String nome, String email, String cpf) {
    public PacienteListagemDTO(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
