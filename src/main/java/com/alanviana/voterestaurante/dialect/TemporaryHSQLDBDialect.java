package com.alanviana.voterestaurante.dialect;

import org.hibernate.dialect.HSQLDialect;

public class TemporaryHSQLDBDialect extends HSQLDialect {

	public boolean supportsSequences() {
		return false;
	}
}