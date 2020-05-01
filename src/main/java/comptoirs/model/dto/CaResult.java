/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dto;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author marisolcanavy
 */
public class CaResult {
    public CaResult(String libelle, BigDecimal unites) {
		this.unites = unites;
		this.libelle = libelle;
	}
	
	public CaResult() {
		this("Inconnu", BigDecimal.valueOf(0l));
	}
	
	// Pas utile de mettre des "getter" ici (final)
	@XmlElement
	public final BigDecimal unites;

	@XmlElement
	public final String libelle;
}
