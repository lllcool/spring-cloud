package com.post.cloud.state.machine.entity;import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.messaging.support.GenericMessage;

public class StateMessage<T> extends GenericMessage<T> {
    private static final long serialVersionUID = 3822349578970192942L;

    private StateEntity entity;

    public StateMessage(T payload, StateEntity entity) {
        super(payload);

        this.entity = entity;
    }

    public StateEntity getEntity() {
        return entity;
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
