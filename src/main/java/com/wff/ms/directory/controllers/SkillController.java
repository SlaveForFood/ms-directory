package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.SkillCreateDto;
import com.wff.ms.directory.models.dto.SkillDto;
import com.wff.ms.directory.models.entity.Skill;
import com.wff.ms.directory.modules.mappers.SkillMapper;
import com.wff.ms.directory.services.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/skills")
@Tag(name = "Скил", description = "Контроллер по добавлению, настройке скилов")
public class SkillController {
  private final SkillService skillService;

  private final SkillMapper skillMapper;

  @Operation(
      summary = "Добавление скила",
      description = "Создает скил с переданными характеристиками")
  @PostMapping
  public ResponseEntity<SkillDto> create(@RequestBody SkillCreateDto skillCreateDto) {
    return ResponseEntity.status(201).body(skillService.create(new Skill()));
  }
}
