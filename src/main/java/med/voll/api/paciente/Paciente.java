package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Paciente(PacienteDadosDTO paciente) {
        this.ativo = true;
       this.nome = paciente.nome();
       this.email = paciente.email();
       this.telefone = paciente.telefone();
       this.cpf = paciente.cpf();
       this.endereco = new Endereco(paciente.endereco());
    }

    public void atualizarDados(DataPutPaciente dataPutPaciente) {
        if (dataPutPaciente.nome() != null){
            this.nome = dataPutPaciente.nome();
        }
        if (dataPutPaciente.telefone() != null){
            this.telefone = dataPutPaciente.telefone();
        }
        if (dataPutPaciente.endereco() != null){
            this.endereco = new Endereco(dataPutPaciente);
        }
    }

    public void desativar() {
        this.ativo = false;
    }
}
