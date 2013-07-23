package sastruts.exam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Systemlogテーブルと対応するEntityクラスです。
 * @author W.Ryozo
 *
 */
@Entity
@Table(name="Systemlog")
public class Systemlog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long id;
	
	@Column(name="preinfo")
	public String preinfo;
	
	@Column(name="postinfo")
	public String postinfo;
	
	/** Version */
	@Version
	@Column(name="version")
	public Long version;

}
