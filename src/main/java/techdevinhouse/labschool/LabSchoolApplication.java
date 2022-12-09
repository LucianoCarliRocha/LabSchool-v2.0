package techdevinhouse.labschool;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import techdevinhouse.labschool.Model.Aluno;
import techdevinhouse.labschool.Model.Pedagogo;
import techdevinhouse.labschool.Model.Professor;
import techdevinhouse.labschool.Service.AlunoService;
import techdevinhouse.labschool.Service.PedagogoService;
import techdevinhouse.labschool.Service.ProfessorService;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.EstadoProfessor;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.ExperienciaProfessor;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.FormacaoAcademica;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.SituacaoAluno;
import java.time.LocalDate;

@Data
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootApplication
public class LabSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSchoolApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
 //       messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    CommandLineRunner run(AlunoService alunoService, ProfessorService professorService, PedagogoService pedagogoService) {
        return args -> {
            if (alunoService.consultarAluno().isEmpty()) {
                alunoService.salvar(new Aluno(null, "Bart Simpson", "11-11111-1212", LocalDate.of(2014, 10, 29), 11839750073l, SituacaoAluno.IRREGULAR, 3.5f));
                alunoService.salvar(new Aluno(null, "Lisa Simpson", "11-22222-2222", LocalDate.of(2012, 10, 29), 17158947076l, SituacaoAluno.ATIVO, 10f));
                alunoService.salvar(new Aluno(null, "Meggie Simpson", "12-20002-2200", LocalDate.of(2019, 10, 29), 63701210020l, SituacaoAluno.ATIVO, 9f));
                alunoService.salvar(new Aluno(null, "Milhouse Van Houten", "11-33333-2222", LocalDate.of(2014, 10, 29), 30119137062l, SituacaoAluno.ATIVO, 8f));
                alunoService.salvar(new Aluno(null, "Nelson Muntz", "11-44333-4444", LocalDate.of(2007,10, 29), 95704094015l, SituacaoAluno.INATIVO, 2f));
            }
            if (professorService.consultarProfessor().isEmpty()) {
                professorService.salvarProfessor(new Professor(null, "Walter White", "14-22998-1882", LocalDate.of(1982, 10, 30), 40539019011l, FormacaoAcademica.MESTRADO, ExperienciaProfessor.FULL_STACK, EstadoProfessor.ATIVO));
                professorService.salvarProfessor(new Professor(null, "Jesse Pinkman", "44-11111-1992", LocalDate.of(1997, 10, 30), 96107295097l, FormacaoAcademica.GRADUACAO_INCOMPLETA, ExperienciaProfessor.BACK_END, EstadoProfessor.ATIVO));
                professorService.salvarProfessor(new Professor(null, "Hank Schrader", "44-11111-100", LocalDate.of(1984, 10, 30), 70685977005l, FormacaoAcademica.MESTRADO, ExperienciaProfessor.FULL_STACK, EstadoProfessor.ATIVO));
                professorService.salvarProfessor(new Professor(null, "Gustavo Fring", "44-11001-1002", LocalDate.of(1977, 10, 30), 57408927085l, FormacaoAcademica.GRADUACAO_COMPLETA, ExperienciaProfessor.FRONT_END, EstadoProfessor.INATIVO));
                professorService.salvarProfessor(new Professor(null, "Saul Goodman", "44-11998-1882", LocalDate.of(1980, 10, 30), 86940162062l, FormacaoAcademica.MESTRADO, ExperienciaProfessor.FULL_STACK, EstadoProfessor.ATIVO));

            }

            if (pedagogoService.consultarPedagogo().isEmpty()) {
                pedagogoService.salvarPedagogo(new Pedagogo(null, "John Snow", "11-67333-4454", LocalDate.of(2000, 10, 30), 62316840086l));
                pedagogoService.salvarPedagogo(new Pedagogo(null, "Sansa Stark", "22-22333-4454 ", LocalDate.of(2004, 10, 30), 49850253053l));
                pedagogoService.salvarPedagogo(new Pedagogo(null, " Tyrion Lannister", "33-77333-4454", LocalDate.of(1990, 10, 30), 39125106015l));
                pedagogoService.salvarPedagogo(new Pedagogo(null, " Sandor Clegane", "11-33333-2222", LocalDate.of(1995, 10, 30), 89089606009l));


            }
        };
    }
}