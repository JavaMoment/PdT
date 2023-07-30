package com.enums;

public enum Asistencia {
	PENDIENTE(0.0d),
	ASISTENCIA(1.0d),
	MEDIA_ASISTENCIA_VESPERTINA(0.5d),
	MEDIA_ASISTENCIA_MATUTINA(0.5d),
	AUSENCIA(0.0d),
	AUSENCIA_JUSTIFICADA(0.5d);
	
	public final double value;
	
	private Asistencia(double value) {
		this.value = value;
	}
}
/*enum Asistencia {
	PENDIENTE,
	ASISTENCIA,
	MEDIA_ASISTENCIA_VESPERTINA,
	MEDIA_ASISTENCIA_MATUTINA,
	AUSENCIA,
	AUSENCIA_JUSTIFICADA
}*/
