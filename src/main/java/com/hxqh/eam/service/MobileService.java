package com.hxqh.eam.service;

import com.hxqh.eam.model.dto.Mob88Dto;
import com.hxqh.eam.model.dto.Mob91Dto;
import com.hxqh.eam.model.dto.Mob92Dto;
import com.hxqh.eam.model.dto.VMob87Dto;
import com.hxqh.eam.model.view.VMob86;
import com.hxqh.eam.model.view.VMob87;
import com.hxqh.eam.model.view.VMob87Class;
import com.hxqh.eam.model.view.VMob92;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface MobileService {

    Mob91Dto vMob91Data();

    Mob92Dto vMob92Data();

    List<VMob86> vMob86Data();

    VMob87Dto vMob87Data();

    Mob88Dto getMob88Data();
}
