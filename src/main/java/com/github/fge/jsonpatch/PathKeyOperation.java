/*
 * Copyright (c) 2014, Francis Galiegue (fgaliegue@gmail.com)
 *
 * This software is dual-licensed under:
 *
 * - the Lesser General Public License (LGPL) version 3.0 or, at your option, any
 *   later version;
 * - the Apache Software License (ASL) version 2.0.
 *
 * The text of this file and of both licenses is available at the root of this
 * project or, if you have the jar distribution, in directory META-INF/, under
 * the names LGPL-3.0.txt and ASL-2.0.txt respectively.
 *
 * Direct link to the sources:
 *
 * - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
 * - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
 */

package com.github.fge.jsonpatch;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.github.fge.jackson.jsonpointer.JsonPointer;

/**
 * Base class for patch operations taking a key value in addition to a path
 */
public abstract class PathKeyOperation
    extends JsonPatchOperation
{
    @JsonSerialize
    protected final String newkey;

    /**
     * Protected constructor
     *
     * @param op operation name
     * @param path affected path
     * @param value JSON value
     */
    protected PathKeyOperation(final String op, final JsonPointer path,
        final String newkey)
    {
        super(op, path);
        this.newkey = newkey;
    }

    @Override
    public final void serialize(final JsonGenerator jgen,
        final SerializerProvider provider)
        throws IOException, JsonProcessingException
    {
        jgen.writeStartObject();
        jgen.writeStringField("op", op);
        jgen.writeStringField("path", path.toString());
        jgen.writeStringField("newkey", newkey);
        //jgen.writeTree(value);
        jgen.writeEndObject();
    }

    @Override
    public final void serializeWithType(final JsonGenerator jgen,
        final SerializerProvider provider, final TypeSerializer typeSer)
        throws IOException, JsonProcessingException
    {
        serialize(jgen, provider);
    }

    @Override
    public final String toString()
    {
        return "op: " + op + "; path: \"" + path + "\"; newkey: " + newkey;
    }
}
