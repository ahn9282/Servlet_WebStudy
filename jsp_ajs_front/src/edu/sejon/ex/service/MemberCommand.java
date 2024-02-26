package edu.sejon.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejon.ex.dto.MemberDto;

public interface MemberCommand {
void execute(HttpServletRequest request, HttpServletResponse response);

}
