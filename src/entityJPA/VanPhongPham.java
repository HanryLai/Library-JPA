package entityJPA;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "VanPhongPham")

public class VanPhongPham extends SanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mauSac")
	private MauSac	mauSac;

	@Column(columnDefinition = "NVARCHAR(255)")
  	private String noiSanXuat;

	@Override
	public String toString() {
		return "VanPhongPham{" +
				"mauSac=" + mauSac.getMaMau() +
				", noiSanXuat='" + noiSanXuat + '\'' +
				'}';

	}
}
