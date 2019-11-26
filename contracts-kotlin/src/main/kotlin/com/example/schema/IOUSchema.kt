package com.example.schema

import net.corda.core.schemas.MappedSchema
import net.corda.core.schemas.PersistentState
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * The family of schemas for IOUState.
 */
object IOUSchema

/**
 * An IOUState schema.
 */
object IOUSchemaV1 : MappedSchema(
        schemaFamily = IOUSchema.javaClass,
        version = 1,
        mappedTypes = listOf(PersistentIOU::class.java)) {
    @Entity
    @Table(name = "iou_states")
    class PersistentIOU(
            @Column(name = "lender")
            var lenderName: String,

            @Column(name = "borrower")
            var borrowerName: String,

            @Column(name = "linear_id")
            var linearId: UUID,

            @Column(name = "product_name")
            var productName: String,

            @Column(name = "product_colour")
            var productColour: String,

            @Column(name = "status")
            var status: String

    ) : PersistentState() {
        // Default constructor required by hibernate.
        constructor(): this("", "", UUID.randomUUID(),"","","")

    }
}