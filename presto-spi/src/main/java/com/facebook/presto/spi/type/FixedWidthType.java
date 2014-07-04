/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.spi.type;

import com.facebook.presto.spi.block.BlockBuilder;
import io.airlift.slice.Slice;
import io.airlift.slice.SliceOutput;

/**
 * FixedWidthType is a type that has a fixed size for every value.
 */
public interface FixedWidthType
        extends Type
{
    /**
     * Gets the size of a value of this type is bytes. All values
     * of a FixedWidthType are the same size.
     */
    int getFixedSize();

    /**
     * Creates a block builder for this type sized to hold the specified number
     * of positions.
     */
    BlockBuilder createFixedSizeBlockBuilder(int positionCount);

    /**
     * Writes the boolean value into the specified slice output.
     */
    void writeBoolean(SliceOutput sliceOutput, boolean value);

    /**
     * Writes the long value into the specified slice output.
     */
    void writeLong(SliceOutput sliceOutput, long value);

    /**
     * Writes the double value into the specified slice output.
     */
    void writeDouble(SliceOutput sliceOutput, double value);

    /**
     * Writes the Slice value into the specified slice output.
     */
    void writeSlice(SliceOutput sliceOutput, Slice value, int offset);
}