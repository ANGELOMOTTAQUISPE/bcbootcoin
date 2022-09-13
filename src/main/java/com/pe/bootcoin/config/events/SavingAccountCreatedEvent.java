package com.pe.bootcoin.config.events;

import com.pe.bootcoin.model.balanceCuentaMongo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SavingAccountCreatedEvent extends Event<balanceCuentaMongo> {

}
