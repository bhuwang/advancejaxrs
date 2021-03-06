/**
 * 
 */
package com.bhuwan.advancejaxrs.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bhuwan.advancejaxrs.messanger.model.Comment;
import com.bhuwan.advancejaxrs.messanger.service.CommentService;

/**
 * @author bhuwan
 *
 */
@Path("/")
@Consumes(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CommentResource {

    CommentService commentService = new CommentService();

    @GET
    public List<Comment> getComments(@PathParam("messageId") long messageId) {
        return commentService.getAllComments(messageId);
    }

    @GET
    @Path("/{commentId}")
    public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
        return commentService.getComment(messageId, commentId);
    }

    @POST
    public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
        return commentService.addComment(messageId, comment);
    }

    @PUT
    @Path("/{commentId}")
    public Comment updateProfile(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment) {
        comment.setId(commentId);
        return commentService.updateComment(messageId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    public void deleteProfile(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
        commentService.removeComment(messageId, commentId);
    }

}
