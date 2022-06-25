package br.com.magnasistemas.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_COMPANY", schema = "employee")
public class CompanyEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "COMPANY_NAME", length = 40)
	private String name;

	@Column(name = "CNPJ", unique = true, nullable = false, length = 14)
	private String cnpj;

	@Column(name = "FOUNDATION_DATE", nullable = false, length = 10)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String foundationDate;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_STATUS", referencedColumnName = "ID")
	private StatusEntity status;

	public CompanyEntity() {
	}

	public CompanyEntity(Long id, String name, String cnpj, String foundationDate, StatusEntity status) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.foundationDate = foundationDate;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getFoundationDate() {
		return foundationDate;
	}

	public void setFoundationDate(String foundationDate) {
		this.foundationDate = foundationDate;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, foundationDate, id, name, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyEntity other = (CompanyEntity) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(foundationDate, other.foundationDate)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "CompanyEntity [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", foundationDate=" + foundationDate
				+ ", status=" + status + "]";
	}

	

}
