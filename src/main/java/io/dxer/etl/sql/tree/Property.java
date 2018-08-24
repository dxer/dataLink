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
package io.dxer.etl.sql.tree;

import com.google.common.base.Optional;

import java.util.List;
import java.util.Objects;

import static com.google.common.base.Objects.toStringHelper;
import static java.util.Objects.requireNonNull;

public class Property extends Node {

    private String key;
    private String value;

    public Property(String key, String value) {
        this(Optional.<NodeLocation>absent(), key, value);
    }

    public Property(NodeLocation location, String key, String value) {
        this(Optional.of(location), key, value);
    }

    private Property(Optional<NodeLocation> location, String key, String value) {
        super(location);
        this.key = requireNonNull(key, "key is null");
        this.value = requireNonNull(value, "value is null");
    }


    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitProperty(this, context);
    }

    @Override
    public List<? extends Node> getChildren() {
//        return ImmutableList.of(key, value);
        return null;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Property other = (Property) obj;
        return Objects.equals(key, other.key) &&
                Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("key", key)
                .add("value", value)
                .toString();
    }
}
