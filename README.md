# Ejercicios de listas enlazadas en Java

**Estudiante:** Pedro Garcia Mata
**Grupo:** GTID244
**Fecha:** 26/10/2026

## Ejercicios resueltos

| # | Problema | Tipo de lista | Idea |
|---|----------|---------------|------|
| 1 | Cafetería UAM | Lista simple (cabeza y cola) | Dos colas FIFO; se atiende primero a trabajadores |
| 3 | Botella de agua | Lista simple | Se recorre la lista buscando el menor precio |
| 5 | Ticket de compras | Lista simple | Inserción ordenada (mayor a menor precio) y suma con BigDecimal |
| 7 | Cuadro de honor | Lista doble | Inserción ordenada alfabéticamente solo de quienes tienen >= 9.5 |

No se usa `LinkedList`, `ArrayList` ni `Vector`; todas las estructuras son propias (`Nodo`, `ListaSimple`, `ListaDoble`).

## Cómo compilar y ejecutar

```bash
cd ejercicio1_Cafeteria
javac *.java
java Main < entrada.txt
```

(Igual para las demás carpetas.)

## Envío a omegaUp

omegaUp requiere un solo archivo. En `omegaup_envio/` están las versiones de cada ejercicio
unidas en un único `Main.java` (clases `Nodo`, `Lista*` y `Main` en el mismo archivo).
