package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.repository.UserProfileRepository;
import DKSPACE.PhamarERP.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
	private final UserProfileRepository repository;
}