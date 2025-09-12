package med.voll.api.paciente;

public record PacienteListagemDTO(Long id, String nome, String email, String cpf, boolean ativo) {
    public PacienteListagemDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.isAtivo());
    }
}
