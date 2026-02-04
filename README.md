# Taller Persistencia

## Enlaces de interés

- [BookstoreBack](https://github.com/Uniandes-isis2603/bookstore-back) -> Repositorio de referencia para el Back

Movie – Director (@ManyToOne / @OneToMany)
Relación

Movie → Director: @ManyToOne

Director → Movie: @OneToMany(mappedBy = "director")

Una película tiene un solo director, mientras que un director puede dirigir muchas películas a lo largo de su carrera. Por eso Movie es el lado dueño de la relación. La clave foránea director_id vive en la tabla movie.

En Director, se usa mappedBy = "director" para indicar que Director no gestiona la relación. Ya está definida en Movie. Se crea una sola columna director_id en movie, tampoco se crean columnas adicionales ni tablas innecesarias y se evita duplicar la relación

Movie – Genre (@ManyToMany)

Es una relación bidireccional. Una película puede pertenecer a varios géneros (acción, drama, etc.) y un género puede estar asociado a muchas películas. Como es una relación de muchos a muchos, se requiere una tabla intermedia.

Un lado (por ejemplo Movie) define la @JoinTable y el otro (Genre) usa mappedBy = "genres". Esto garantiza que solo una tabla intermedia sea creada. Asimismo, que la relación tenga un único dueño. Por ende, se crea una tabla intermedia, no se duplican tablas ni llaves. Se mantiene coherencia entre ambos lados

Movie – Script (@OneToOne)

Cada película tiene un único guion, y cada guion pertenece a una sola película.
Por tanto, la relación es estrictamente uno a uno.

Movie es el dueño de la relación y Script depende conceptualmente de Movie. Si Script tiene la relación inversa, usa mappedBy para indicar que no debe crearse una segunda clave foránea. La FK está controlada desde Movie

Entonces, se crea una sola llave foránea. No se generan columnas duplicadas.
