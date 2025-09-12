package med.voll.api.paciente;

import med.voll.api.endereco.Endereco;

public record DataPutPaciente(Long id, String nome, String telefone, Endereco endereco) {
}
